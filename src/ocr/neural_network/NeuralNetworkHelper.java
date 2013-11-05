package ocr.neural_network;

import java.io.File;
import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.persist.EncogDirectoryPersistence;

public class NeuralNetworkHelper {

    public static BasicNetwork create(int input, int output) {
        return create(input, output, 0);
    }
    
    public static BasicNetwork create(int input, int output, int hidden) {
        BasicNetwork network = new BasicNetwork();
        network.addLayer(new BasicLayer(null, true, input));
        
        if(hidden != 0){
            network.addLayer(new BasicLayer(new ActivationSigmoid(), true, hidden));
        }
        
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, output));
        network.getStructure().finalizeStructure();
        network.reset();
        Encog.getInstance().shutdown();
        
        return network;
    }
    
    public static void train(BasicNetwork network) {
        // TODO: Add functionality
    }
    
    public static void persist(String filename, BasicNetwork network) {
        EncogDirectoryPersistence.saveObject(new File(filename), network);
        Encog.getInstance().shutdown();
    }
}