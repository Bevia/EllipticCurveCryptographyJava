package org.example;

import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        try {
            // 1. Create a KeyPairGenerator for ECC
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");

            // 2. Initialize it with a specific curve (NIST P-256 in this case)
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));

            // 3. Generate the key pair (public and private keys)
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // 4. Print the keys in Base64 encoded format
            System.out.println("Generated ECC Key Pair:");
            System.out.println("Private Key (Base64): " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));
            System.out.println("Public Key (Base64): " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}