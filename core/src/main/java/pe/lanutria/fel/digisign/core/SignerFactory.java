/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.lanutria.fel.digisign.core;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

/**
 *
 * @author carlosecheverria
 */
public class SignerFactory {

    private final Map<String, Signer> signers = new ConcurrentSkipListMap<>();

    
    public Signer get(String identifier) {
        return signers.get(identifier);
    }

    //loads a signer into the factory
    public void load(String identifier, Signer signer) {
        signers.put(identifier, signer);
    }

    //used for GUI purposes
    public List<String> getKeys() {
        return signers.keySet().stream().collect(Collectors.toList());
    }

}
