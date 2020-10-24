package com.company;

public class Main {

    public static void main(String[] args) {

        float input =  0.14913F;

        float[] weightsOfInput = new float[4];
        float[] weightsOfHiddenLayer = new float[4];
        float[] outputsOfHiddenLayer = new float[4];
        float[] updatedLocalGradientsOfHiddenLayer = new float[4];
        float[] updatedWeightsOfInputLayer = new float[4];
        float[] updatedWaightsOfHiddenLayer = new float[4];
        float[] biasOfHiddenLayer = new float[4];
        float learningRate = 0.2F;
        float desiredOutput ;
        float biasofOutputLayer;
        float updatedBiasofOutputLayer;
        float receivedOutput;

        MultilayerPerceptron multilayerPerceptron = new MultilayerPerceptron();

       weightsOfInput = multilayerPerceptron.initializeWeightsOfInput();
       weightsOfHiddenLayer =  multilayerPerceptron.initializeWeightsOfHiddenLayer();
       biasOfHiddenLayer = multilayerPerceptron.initializeBiasofHiddenLayer();
       biasofOutputLayer = multilayerPerceptron.initializeBiasOfOutputLayer();
       desiredOutput =multilayerPerceptron.calculateDesiredOutput(input);


        System.out.println("Input = " + input);
        System.out.println("Desired output = " + desiredOutput);



        outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(input , weightsOfInput  , biasOfHiddenLayer);

        receivedOutput = multilayerPerceptron.calculateOutput(weightsOfHiddenLayer , outputsOfHiddenLayer, biasofOutputLayer);


        System.out.println("Received output = " + receivedOutput);

       float error = desiredOutput - receivedOutput;
        System.out.println("error (before  update) = " + error);


       if(error != 0){

           for(int i =0; i < 40; i++){

              updatedWaightsOfHiddenLayer = multilayerPerceptron.updateHiddenLayerWeights(error,learningRate);
              updatedBiasofOutputLayer = multilayerPerceptron.updateOutputLayerBias(error, learningRate);
              updatedLocalGradientsOfHiddenLayer = multilayerPerceptron.updateLocalGradientsOfHiddenLayer(error, updatedWaightsOfHiddenLayer, outputsOfHiddenLayer );
              updatedWeightsOfInputLayer = multilayerPerceptron.updateInputParameters(input , weightsOfInput, updatedLocalGradientsOfHiddenLayer,learningRate);
              outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(input , updatedWeightsOfInputLayer, biasOfHiddenLayer);
              receivedOutput = multilayerPerceptron.calculateOutput( updatedWaightsOfHiddenLayer, outputsOfHiddenLayer , updatedBiasofOutputLayer);
              error = desiredOutput - receivedOutput;
              System.out.println("error (after update) = " + error);

           }
       }

        System.out.println("error = " + error);


    }
}
