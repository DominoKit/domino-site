package org.dominokit.samples.processor;

import com.google.auto.service.AutoService;
import org.dominokit.samples.annotations.ComponentClass;
import org.dominokit.samples.annotations.ComponentSample;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AutoService(Processor.class)
public class SamplesProcessor extends AbstractProcessor {

    private final Set<String> supportedAnnotations = new HashSet<>();

    public SamplesProcessor() {
        supportedAnnotations.add(ComponentClass.class.getCanonicalName());
        supportedAnnotations.add(ComponentSample.class.getCanonicalName());
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return supportedAnnotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        new SampleCodeProcessorStep.Builder()
                .setProcessingEnv(processingEnv)
                .build()
                .process(roundEnv.getElementsAnnotatedWith(ComponentClass.class)
                        .stream()
                        .filter(element -> ElementKind.CLASS.equals((element.getKind())))
                        .collect(Collectors.toSet())
                );
        return false;
    }
}
