import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            //crearJson();
            //levantar();
            //System.out.println(crearJson().toString());
            //ejemploJson2();
            //levantarArreglo2();
            objetoEnroscado();
            leventarCompu();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
    static String crearJson() throws JSONException{
        JSONObject jsonObject = new JSONObject();  //creo objeto
        jsonObject.put("Hola",5);                   //agrego dos atributos
        jsonObject.put("Chau","algo");

        JSONArray jsonArray = new JSONArray();      //creo arreglo
        jsonArray.put(3);                           //agrego tres enteros
        jsonArray.put(4);
        jsonArray.put(5);
        jsonObject.put("Arreglo",jsonArray );       //agrego el arreglo como valor de la variable arreglo

        return jsonObject.toString();

    }

    static void levantar() throws JSONException {
        String cadena = crearJson();
        JSONObject obj = new JSONObject(cadena);
        System.out.println(obj.getInt("Hola"));
        System.out.println(obj.getString("Chau"));     //levantamos los 2 atributos del objeto

        JSONArray arre = obj.getJSONArray("Arreglo");   //arreglo es el valor de un atributo
        for(int i = 0; i < arre.length(); i++){
            //Integer numero = arre.getInt(i);          //recibe en variable int numeros int
            System.out.println(arre.getInt(i));         //tambien se puede pasar la var numero por parametro
        }

    }
    static String ejemploJson2() throws JSONException {  //arreglo de 3 objetos iguales
        JSONArray arreglito = new JSONArray();         //creamos arreglo
        for(int i = 0; i < 3; i++){
            JSONObject objetoEnArreglo = new JSONObject();       //creamos objetos iguales
            objetoEnArreglo.put("Uno","Primer atributo" );         //guardamos las clave y valor en el objeto
            objetoEnArreglo.put("Dos",2.23 );
            objetoEnArreglo.put("Tres",true );
            arreglito.put(objetoEnArreglo);      //guardamos el objeto en el arreglo
        }

        //System.out.println(arreglito);
        return arreglito.toString();
    }
    static void levantarArreglo2() throws JSONException{
        String cadenaJson = ejemploJson2();

        JSONArray arre = new JSONArray(cadenaJson);   //creo arreglo que recibe el string

        for(int i = 0;i < arre.length(); i++) {            //recorro
            JSONObject object = arre.getJSONObject(i);     //creamos objeto con el metodo getJSONObject del arreglo(i)
            System.out.println(object.getString("Uno"));
            System.out.println(object.getDouble("Dos"));
            System.out.println(object.getBoolean("Tres"));   //   [ { "Uno" : "Primer atributo" , "Dos" : 2.23 , "Tres" : true } ]
        }                                                        //en el ejemplo anterior se carga 3 veces el objeto en el arreglo
    }

    static String objetoEnroscado() throws JSONException {

        JSONArray memoriaRam = new JSONArray();  //arreglo de memoria ram
        memoriaRam.put(8);
        memoriaRam.put(8);
        memoriaRam.put(8);

        JSONObject objetoAdentro = new JSONObject();  //objeto partes del interior de la pc
        objetoAdentro.put("Procesador","intel" );
        objetoAdentro.put("Mother","Gigabyte" );
        objetoAdentro.put("RAM",memoriaRam );    //metemos el arreglo  de ram como valor de un elemento del objeto

        JSONObject objetoAfuera1 = new JSONObject();  //parte de afuera de la pc
        objetoAfuera1.put("Mouse", true);
        objetoAfuera1.put("Teclado","Ingles" );
        objetoAfuera1.put("Puertos",4 );
        objetoAfuera1.put("Interior",objetoAdentro ); //metemos el objeto interior como valor de este objeto

        JSONObject caja = new JSONObject();
        caja.put("Computadora",objetoAfuera1 );       //metemos la pc en la caja

        JSONArray muchasCompus = new JSONArray();   //arreglo de objetos caja(con pc)
        muchasCompus.put(caja);
        muchasCompus.put(caja);
        muchasCompus.put(caja);

        //System.out.println(muchasCompus);

        return muchasCompus.toString();
    }

    static void leventarCompu() throws JSONException {
        String arregloDeCompus = objetoEnroscado();

        JSONArray arreglo1 = new JSONArray(arregloDeCompus);
        for (int i = 0; i < arreglo1.length(); i++){             // [
            JSONObject caja = arreglo1.getJSONObject(i);          //  {

            JSONObject segundo = caja.getJSONObject("Computadora");  // "Computadora" : {
            System.out.println(segundo.getBoolean("Mouse"));    //                   "Mouse" : true ,
            System.out.println(segundo.getString("Teclado"));   //                   "Teclado" : "ingles" ,
            System.out.println(segundo.getInt("Puertos"));      //                   "Puertos" : 4 ,

            JSONObject otro = segundo.getJSONObject("Interior");   //                    "Interior" : {
            System.out.println(otro.getString("Mother"));      //                                  "Mother" : "Gigabyte" ,
            System.out.println(otro.getString("Procesador"));   //                                 "Procesador" : "Intel" ,

            JSONArray ram = otro.getJSONArray("RAM");        //                                  "RAM" :
            for(int j = 0; j < ram.length(); j++) {              //                                          [
                System.out.println(ram.getInt(j));              //                                             8 , 8 , 8 ] }
            }                                                   //                                                             }
                                                                //                                                                 }

        }

    }

}
