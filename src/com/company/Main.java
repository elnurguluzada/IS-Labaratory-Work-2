package com.company;

public class Main {

    public static void main(String[] args) {

        float input =  0.14913F;

        float[] inputVector = new float[50];
        float[] weightsOfInput = new float[4];
        float[] weightsOfHiddenLayer = new float[4];
        float[] outputsOfHiddenLayer = new float[4];
        float[] updatedLocalGradientsOfHiddenLayer = new float[4];
        float[] updatedWeightsOfInputLayer = new float[4];
        float[] updatedWaightsOfHiddenLayer = new float[4];
        float[] biasOfHiddenLayer = new float[4];
        float[] updatedBiasOfHiddenLayer = new float[4];
        float learningRate = 0.2F;
        float[] desiredOutput  = new  float[50];
        float biasofOutputLayer;
        float updatedBiasofOutputLayer;
        float[] receivedOutput  = new float[50];
        float error;

       MultilayerPerceptron multilayerPerceptron = new MultilayerPerceptron();
       inputVector = multilayerPerceptron.initializeValuesofInputVector();
       weightsOfInput = multilayerPerceptron.initializeWeightsOfInput();
       weightsOfHiddenLayer =  multilayerPerceptron.initializeWeightsOfHiddenLayer();
       biasOfHiddenLayer = multilayerPerceptron.initializeBiasofHiddenLayer();
       biasofOutputLayer = multilayerPerceptron.initializeBiasOfOutputLayer();

       //desiredOutput =multilayerPerceptron.calculateDesiredOutput(input);



        System.out.println("Input = " + input);
       //System.out.println("Desired output = " + desiredOutput);


        for(int j =0; j < 1000; j++) {


            for (int i = 0; i < inputVector.length; i++) {

                desiredOutput[i] = multilayerPerceptron.calculateDesiredOutput(inputVector[i]);

                outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(inputVector[i], weightsOfInput, biasOfHiddenLayer);
                receivedOutput[i] = multilayerPerceptron.calculateOutput(weightsOfHiddenLayer, outputsOfHiddenLayer, biasofOutputLayer);

                error = desiredOutput[i] - receivedOutput[i];


                updatedWaightsOfHiddenLayer = multilayerPerceptron.updateHiddenLayerWeights(error, learningRate);
                updatedBiasofOutputLayer = multilayerPerceptron.updateOutputLayerBias(error, learningRate);
                updatedLocalGradientsOfHiddenLayer = multilayerPerceptron.updateLocalGradientsOfHiddenLayer(error, updatedWaightsOfHiddenLayer, outputsOfHiddenLayer);
                updatedBiasOfHiddenLayer = multilayerPerceptron.updateHiddenLayerBiases(updatedLocalGradientsOfHiddenLayer, learningRate);
                updatedWeightsOfInputLayer = multilayerPerceptron.updateInputParameters(input, weightsOfInput, updatedLocalGradientsOfHiddenLayer, learningRate);
                outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(input, updatedWeightsOfInputLayer, updatedBiasOfHiddenLayer);
                receivedOutput[i] = multilayerPerceptron.calculateOutput(updatedWaightsOfHiddenLayer, outputsOfHiddenLayer, updatedBiasofOutputLayer);

//                System.out.println("desired output = " + desiredOutput[i]);
//                System.out.println("received output = " + receivedOutput);


            }
        }


        System.out.println("*****************************************************************");


        //  Without updating received outputs and desired outputs

        for (int i = 0; i < inputVector.length; i++) {

            System.out.println("Input Number  " + (i+1));
            desiredOutput[i] = multilayerPerceptron.calculateDesiredOutput(inputVector[i]);
            System.out.println("Desired output [" + i +"] = " + desiredOutput[i]);

            outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(inputVector[i], weightsOfInput, biasOfHiddenLayer);
            receivedOutput[i] = multilayerPerceptron.calculateOutput(weightsOfHiddenLayer, outputsOfHiddenLayer, biasofOutputLayer);

            System.out.println("Recieved output[" + i +"] = " + receivedOutput[i]);
            System.out.println("###################################################");
        }





//        outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(input , weightsOfInput  , biasOfHiddenLayer);
//
//        receivedOutput = multilayerPerceptron.calculateOutput(weightsOfHiddenLayer , outputsOfHiddenLayer, biasofOutputLayer);
//



//       // System.out.println("Received output = " + receivedOutput);
//
//       float error = desiredOutput - receivedOutput;
//       // System.out.println("error (before  update) = " + error);
//
//
//       if(error != 0){
//
//           for(int i =0; i < 100; i++){
//
//              updatedWaightsOfHiddenLayer = multilayerPerceptron.updateHiddenLayerWeights(error,learningRate);
//              updatedBiasofOutputLayer = multilayerPerceptron.updateOutputLayerBias(error, learningRate);
//              updatedLocalGradientsOfHiddenLayer = multilayerPerceptron.updateLocalGradientsOfHiddenLayer(error, updatedWaightsOfHiddenLayer, outputsOfHiddenLayer );
//              updatedBiasOfHiddenLayer = multilayerPerceptron.updateHiddenLayerBiases(updatedLocalGradientsOfHiddenLayer , learningRate);
//              updatedWeightsOfInputLayer = multilayerPerceptron.updateInputParameters(input , weightsOfInput, updatedLocalGradientsOfHiddenLayer,learningRate);
//              outputsOfHiddenLayer = multilayerPerceptron.calculateOutputsOfHiddenLayer(input , updatedWeightsOfInputLayer, updatedBiasOfHiddenLayer);
//              receivedOutput = multilayerPerceptron.calculateOutput( updatedWaightsOfHiddenLayer, outputsOfHiddenLayer , updatedBiasofOutputLayer);
//
//               System.out.println("desired output = " + desiredOutput);
//               System.out.println("received output = " + receivedOutput);
//
//              error = desiredOutput - receivedOutput;
//            //  System.out.println("error (after update) = " + error);
//
//           }
//       }
//
//        System.out.println("error = " + error);
//
//
//




    }
}
