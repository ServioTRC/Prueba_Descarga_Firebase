package mx.itesm.strc.prueba_descarga_firebase;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.BitmapRequestListener;

import java.util.ArrayList;

public class MostrarProducto extends AppCompatActivity {

    ImageView mainImage;
    TextView nombreProducto;
    TextView marca;
    TextView categorias;
    TextView descripcion;
    TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_producto);
        mainImage = findViewById(R.id.mainImage);
        nombreProducto = findViewById(R.id.NombreProducto);
        marca = findViewById(R.id.Marca);
        categorias = findViewById(R.id.Categorias);
        descripcion = findViewById(R.id.Descripcion);
        precio = findViewById(R.id.Precio);
        asignarElementos();
    }

    private void asignarElementos(){
        Producto productoActual = Producto.lista_productos.get(0);
        descargarImagenLibro(productoActual.getUrl_imagenes().get(0));
        nombreProducto.setText(productoActual.getNombre());
        marca.setText(productoActual.getMarca());
        categorias.setText(generarCategorias(productoActual.getCategorias()));
        descripcion.setText(productoActual.getDescripcion());
        precio.setText("$ " + String.format("%.2f", productoActual.getPrecio_promedio()));
    }

    private void descargarImagenLibro(String imagen) {
        AndroidNetworking.get(imagen.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsBitmap(new BitmapRequestListener() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mainImage.setImageBitmap(response);
                        Log.i("Imagen", "Bien");
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.i("Lectura Imagen", anError.toString());
                    }
                });
    }

    private String generarCategorias(ArrayList<CATEGORIAS> categorias){
        String res = "888";
        if(categorias.get(0) == CATEGORIAS.Cosmeticos)
            Log.i("CAT", "Bien");
        res.substring(0, res.length()-2);
        return res;
    }

}
