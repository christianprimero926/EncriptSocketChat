/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author chris
 */
public class RSA {

    // * Algoritmo RSA
    int tamPrimo;
    private BigInteger n, p, q;
    private BigInteger phi;
    private BigInteger e, d;
    private Random r;

    /**
     * Constructor de la clase RSA
     *
     * @param tamPrimo
     */
    public RSA(int tamPrimo) {
        this.tamPrimo = tamPrimo;
        generaPrimos();             //Genera p y q
        generaClaves();             //Genera e y d

    }

    public RSA(BigInteger p, BigInteger q, int tamPrimo) {
        this.tamPrimo = tamPrimo;
        this.p = p;
        this.q = q;
        generaClaves();             //Genera e y d
    }

    public BigInteger bigIntObtenerD() {
        return (d);
    }

    public BigInteger bigIntObtenerN() {
        return (n);
    }

    public void generaPrimos() {
        r = new Random();
        p = BigInteger.probablePrime(tamPrimo, r);
        q = BigInteger.probablePrime(tamPrimo, r);
    }

    public void generaClaves() {
        // n = p * q
        n = p.multiply(q);
        // phi = (p-1)*(q-1)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Elegimos un e coprimo de y menor que n
        e = BigInteger.probablePrime(tamPrimo / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        // d = e^1 mod phi
        d = e.modInverse(phi);
    }

    /**
     * Encripta el texto usando la clave pública
     *
     * @param mensaje Ristra que contiene el mensaje a encriptar
     * @return El mensaje cifrado como un vector de BigIntegers
     */
    public BigInteger[] encripta(String mensaje) {
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] encriptado = new BigInteger[bigdigitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            encriptado[i] = bigdigitos[i].modPow(e, n);
        }

        return (encriptado);
    }

    /**
     * Desencripta el texto cifrado usando la clave privada
     *
     * @param encriptado Array de objetos BigInteger que contiene el texto
     * cifrado que será desencriptado
     * @param msjRsaD BigInteger que posee el valor de d tomado del Socket en
     * sesion
     * @param msjRsaN BigInteger que posee el valor de n tomado del Socket en
     * sesion
     * @return The decrypted plaintext
     */
    public String desencripta(BigInteger[] encriptado, BigInteger msjRsaD, BigInteger msjRsaN) {
        BigInteger[] desencriptado = new BigInteger[encriptado.length];

        for (int i = 0; i < desencriptado.length; i++) {
            desencriptado[i] = encriptado[i].modPow(msjRsaD, msjRsaN);
        }

        char[] charArray = new char[desencriptado.length];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (desencriptado[i].intValue());
        }

        return (new String(charArray));
    }

    public BigInteger getP() {
        return (p);
    }

    public BigInteger getQ() {
        return (q);
    }

    public BigInteger getPhi() {
        return (phi);
    }

    public BigInteger getN() {
        return (n);
    }

    public BigInteger getE() {
        return (e);
    }

    public BigInteger getD() {
        return (d);
    }

}
