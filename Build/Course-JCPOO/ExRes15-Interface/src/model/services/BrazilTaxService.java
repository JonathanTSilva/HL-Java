package model.services;

public class BrazilTaxService {

    // Double com d minusculo (tipo primitivo) pois considera-se que sempre terá e retornará um valor
    public double tax(double amount) {
        if (amount <= 100.0) {
            return amount * 0.2;
        } else {
            return amount * 0.15;
        }
        
    }
    
}
