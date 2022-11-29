import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SynapticServer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			int numLayers = Integer.parseInt(scan.nextLine());
			Layer[] layers = new Layer[numLayers];
			String[] nextLine = scan.nextLine().split(" ");
			for (int j = 0; j < numLayers; j++) {
				layers[j] = new Layer(Integer.parseInt(nextLine[j]));
				String[] neuronInfo = scan.nextLine().split(" ");
				for (int k = 0; k < layers[j].size; k++) {
					List<Double> weights = new ArrayList<Double>();
					if(j==0) {
						for (int l = (k * 64) + k; l < (k * 64) + k + 64; l++) {
							weights.add(Double.parseDouble(neuronInfo[l]));
						}
						layers[j].neurons[k] = new Neuron(Double.parseDouble(neuronInfo[(k * 64) + k + 64]),
								weights);
					} else {
						for (int l = (k * layers[j-1].size) + k; l < (k * layers[j-1].size) + k + layers[j-1].size; l++) {
							weights.add(Double.parseDouble(neuronInfo[l]));
						}
						layers[j].neurons[k] = new Neuron(Double.parseDouble(neuronInfo[(k * layers[j-1].size) + k + layers[j-1].size]),
								weights);
					}
				}
			}
			String[] inputLine = scan.nextLine().split(" ");
			List<Double> pixelInputs = new ArrayList<Double>();
			for (String s : inputLine){
				pixelInputs.add(Double.parseDouble(s));
			}
			List<Double> previousOutput = layers[0].calculate(pixelInputs);
			for (int j = 1; j < layers.length; j++) {
				previousOutput = layers[j].calculate(previousOutput);
			}
			double highest = Double.MIN_VALUE;
			int highestIndex = -1;
			for (int j = 0; j < previousOutput.size(); j++) {
				if(previousOutput.get(j)>highest){
					highest = previousOutput.get(j);
					highestIndex = j;
				}
			}
			switch(highestIndex){
				case 0:
					System.out.println("STOP_SIGN");
					break;
				case 1:
					System.out.println("YIELD");
					break;
				case 2:
					System.out.println("LANE_ENDS");
					break;
				case 3:
					System.out.println("SPEED_LIMIT");
					break;
				case 4:
					System.out.println("CROSSWALK");
					break;
			}

		}
	}
}

class Layer{
	Neuron[] neurons;
	int size;
	public Layer(int size){
		this.size = size;
		neurons = new Neuron[size];
	}

	public List<Double> calculate(List<Double> input){
		List<Double> outputs = new ArrayList<Double>();
		for (int i = 0; i < this.size; i++) {
			outputs.add(neurons[i].calculate(input));
		}
		return outputs;
	}
}

class Neuron{
	double bias;
	List<Double> weights;
	public Neuron(double bias, List<Double> weights){
		this.bias = bias;
		this.weights = weights;
	}

	public double calculate(List<Double> inputs){
		double outTotal = bias;
		for (int i = 0; i < inputs.size(); i++) {
			outTotal+=inputs.get(i)*weights.get(i);
		}
		return Math.max(0, outTotal);
	}
}
