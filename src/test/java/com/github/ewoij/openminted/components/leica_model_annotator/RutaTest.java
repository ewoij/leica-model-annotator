package com.github.ewoij.openminted.components.leica_model_annotator;

import java.io.IOException;
import java.util.Collection;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Assert;
import org.junit.Test;

import com.github.ewoij.openminted.components.leica_model_annotator.LeicaModelAnnotator.LeicaModel;

public class RutaTest {

	@Test
	public void test() throws IOException, UIMAException {
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText("Leica DM6000B");
		AnalysisEngineDescription aed = AnalysisEngineFactory.createEngineDescriptionFromPath("target/classes/com/github/ewoij/openminted/components/leica_model_annotator/LeicaModelAnnotatorRutaAnalysisEngine.xml");
		SimplePipeline.runPipeline(jcas, aed);
		Collection<LeicaModel> select = JCasUtil.select(jcas, LeicaModel.class);
		Assert.assertEquals(1, select.size());
	}

}
