package com.company;

public class Main {

    public static void main(String[] args) {

        float input =  0.14913F;

        float[] weightsOfInput = new float[4];
        float   biasofInput;
        float[] weightsOfHiddenLayer = new float[4];
        float[] biasOfHiddenLayer = new float[4];
        float learningRate = 0.2F;
        float desiredOutput ;
        float   biasofOutputLayer;

        MultilayerPerceptron multilayerPerceptron = new MultilayerPerceptron();

       weightsOfInput = multilayerPerceptron.initializeWeightsOfInput();
       weightsOfHiddenLayer =  multilayerPerceptron.initializeWeightsOfHiddenLayer();
       biasOfHiddenLayer = multilayerPerceptron.initializeBiasofHiddenLayer();
       biasofOutputLayer = multilayerPerceptron.initializeBiasOfOutputLayer();
       desiredOutput =multilayerPerceptron.calculateDesiredOutput(input);


        System.out.println("Input = " + input);
        System.out.println("Desired output = " + desiredOutput);



       float receivedOutput = multilayerPerceptron.calculateOutput(input , weightsOfInput , biasofOutputLayer , weightsOfHiddenLayer , biasOfHiddenLayer, desiredOutput);


        System.out.println("Received output = " + receivedOutput);

       float error = desiredOutput - receivedOutput;


        System.out.println("error = " + error);


    }
}
