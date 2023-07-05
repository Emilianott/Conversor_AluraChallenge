import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Moneda {
    private Double cantidadMoneda;
    private String monedaConvertir;
    private String monedaConvertida;
    private final Double pesosDominicano = 55.56;

    private DecimalFormat formatear = new DecimalFormat("#.##");


    private Map<String, Double> map = new HashMap<>() {
        {
            put("Dolar", 1.00);
            put("Euro", 1.09);
            put("Libras Esterlina", 1.27);
            put("Yen Japones", 0.0069);
            put("Won Sur Coreano", 0.00077);
            put("Pesos Dominicano", 0.018);
        }
    };

    public Moneda(Double cantidadMoneda, String monedaConvertir, String monedaConvertida) {
        this.monedaConvertir = monedaConvertir;
        this.monedaConvertida = monedaConvertida;
        this.cantidadMoneda = cantidadMoneda;
    }


    public String convertirMoneda() {

        if (monedaConvertir == "Pesos Dominicano") {
            double tasaMonedaPesos = this.map.get(monedaConvertir);
            double tasaDolar = tasaMonedaPesos * cantidadMoneda;
            double tasaMonedaOtra = this.map.get(monedaConvertida);
            double resultado = tasaDolar / tasaMonedaOtra;
            return formatear.format(resultado);


        } else {

            double tasaMoneda = this.map.get(monedaConvertir);

            double cantidadEnDolares = tasaMoneda * cantidadMoneda;
            double cantidadEnPesosDomincano = cantidadEnDolares * pesosDominicano;


            return  formatear.format(cantidadEnPesosDomincano);
        }
    }
}
