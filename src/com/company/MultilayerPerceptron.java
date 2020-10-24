package com.company;

public class MultilayerPerceptron {



    public float input =  0.14913F;

    public float[] weightsOfInputLayer = new float[4];
    public float   biasofInput;
    public float[] weightsOfHiddenLayer = new float[4];
    public float[] biasOfHiddenLayer = new float[4];
    public float[] VofHiddenLayers = new float[4];
    public float[] outputsOfHiddenLayers = new float[4];
    public float[] localGradientsOfHiddenLayer = new float[4];

    float biasOfOutputLayer;




    float[] initializeWeightsOfInput(){

        for (int i = 0; i < weightsOfInputLayer.length; i++) {

            weightsOfInputLayer[i] = (float) (Math.random() * (1 - (0)));
//            System.out.println(" weightsOfInputLayer[" + i +"]  = " +weightsOfInputLayer[i]);
        }

        return weightsOfInputLayer;
    }



    float initializeBiasofInput(){

        // initializing bias between 0 and 1
        biasofInput = (float) (Math.random() * (1 - (0)));
//        System.out.println("biasofInput = " + biasofInput);

        return biasofInput;
    }




    float[] initializeWeightsOfHiddenLayer(){

        for (int i = 0; i < weightsOfHiddenLayer.length; i++) {

            weightsOfHiddenLayer[i] = (float) (Math.random() * (1 - (0)));
//            System.out.println(" weightsOfHiddenLayer[" + i +"]  = " +weightsOfHiddenLayer[i]);
        }

        return weightsOfHiddenLayer;
    }


    float[] initializeBiasofHiddenLayer(){

        for (int i = 0; i < biasOfHiddenLayer.length; i++) {

            biasOfHiddenLayer[i] = (float) (Math.random() * (1 - (0)));
//            System.out.println(" biasOfHiddenLayer[" + i +"]  = " +biasOfHiddenLayer[i]);
        }

        return biasOfHiddenLayer;
    }



    float initializeBiasOfOutputLayer(){

        // initializing bias between 0 and 1
        biasOfOutputLayer = (float) (Math.random() * (1 - (0)));
//        System.out.println("biasofInput = " + biasofInput);

        return biasOfOutputLayer;
    }



    float calculateDesiredOutput(float input){

        float desiredOutput = (float) ((1 + Math.sin(2* Math.PI*input / 7)) + (0.3 * Math.sin(2 * Math.PI * input) / 2 ));


        return desiredOutput;
    }



    float calculateOutput( float input ,float[] weightsOfInput,float   biasOfOutputLayer , float[] weightsOfHiddenLayer,float[] biasOfHiddenLayer , float desiredOutput){



        float outputOfOutputLayer = 0;

        float error ;

        for (int i = 0; i <VofHiddenLayers.length; i++){
            VofHiddenLayers[i] = input * weightsOfInput[i] +  biasOfHiddenLayer[i];
            outputsOfHiddenLayers[i] = (float) (1 / (1 + Math.exp(-VofHiddenLayers[i])));
            outputOfOutputLayer += outputsOfHiddenLayers[i]* weightsOfHiddenLayer[i] + biasOfOutputLayer;

        }

        error= desiredOutput - outputOfOutputLayer;



       // System.out.println("error = " + error);


        return  outputOfOutputLayer;

    }




    float[] updateOutputLayerWeights(float error, float learningRate){

        for (int i = 0; i < weightsOfHiddenLayer.length; i++){
            weightsOfHiddenLayer[i]+= weightsOfHiddenLayer[i] + learningRate*error*outputsOfHiddenLayers[i];
        }
        return weightsOfHiddenLayer;
    }


    float updateOutputLayerBias(float error, float learningRate){

        biasOfOutputLayer+= biasOfOutputLayer + learningRate*error;

      return biasOfOutputLayer;
    }



    float[] updateLocalGradientsOfHiddenLayer(float error , float[] updatedWeightsOfOutputLayer, float[] outputsOfHiddenLayers){

        for (int i = 0; i < localGradientsOfHiddenLayer.length; i++){

            localGradientsOfHiddenLayer[i] += outputsOfHiddenLayers[i]*(1-outputsOfHiddenLayers[i])*error*updatedWeightsOfOutputLayer[i];
        }

        return localGradientsOfHiddenLayer;
    }


    float[] updateInputParameters(float input , float[] weightsOfInputLayer ,float[] localGradientsOfHiddenLayer, float learningRate ){

        for (int i = 0; i < weightsOfInputLayer.length; i++){

            weightsOfInputLayer[i]+= weightsOfInputLayer[i] + learningRate * localGradientsOfHiddenLayer[i] * input;

        }

        return weightsOfInputLayer;
    }

}
