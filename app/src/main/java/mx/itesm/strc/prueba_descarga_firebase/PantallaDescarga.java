package mx.itesm.strc.prueba_descarga_firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class PantallaDescarga extends AppCompatActivity {

    ProgressBar progressBar;
    FirebaseDatabase database;
    DatabaseReference ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_descarga);
        progressBar = findViewById(R.id.progressBar);
        //progressBar.setMax(n); CONTAR NUMERO DE ELEMENTOS EN FIREBASE
        progressBar.setProgress(0);
        database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        //agregarRegistros();
        descargarProductos();
    }

    private void descargarProductos(){
        ruta = database.getReference("Productos/");
        ruta.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressBar.setMax((int)dataSnapshot.getChildrenCount());
                int count = 0;
                Producto nuevoProducto;
                for(DataSnapshot item: dataSnapshot.getChildren()) {
                    //Integers subidos a FireBase se vuelven longs en el regreso directo
                    HashMap a = (HashMap) item.getValue();
                    Integer id = Integer.parseInt(a.get("id").toString());
                    String nombre = (String) a.get("nombre");
                    Double precio_promedio = (Double) a.get("precio_promedio");
                    String marca = (String) a.get("marca");
                    String url_marca_logo = (String) a.get("url_marca_logo");
                    ArrayList<String> url_imagenes = (ArrayList<String>) a.get("url_imagenes");
                    ArrayList<CATEGORIAS> categorias = (ArrayList<CATEGORIAS>) a.get("categorias");
                    ArrayList<ArrayList<String>> url_tiendas = (ArrayList<ArrayList<String>>) a.get("url_tiendas");
                    ArrayList<ArrayList<String>> url_sociales = (ArrayList<ArrayList<String>>) a.get("url_sociales");
                    String descripcion = (String) a.get("descripcion");
                    Integer likes = Integer.parseInt(a.get("likes").toString());
                    nuevoProducto = new Producto(id, nombre, precio_promedio, marca, url_marca_logo, url_imagenes, categorias,
                        url_tiendas, url_sociales, descripcion, likes);
                    Producto.lista_productos.add(nuevoProducto);
                    count++;
                    progressBar.setProgress(count);
                }
                Intent intMostrarProductos = new Intent(getBaseContext(), MostrarProducto.class);
                startActivity(intMostrarProductos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void agregarRegistros(){
        Integer id = 1;
        final ArrayList<String> tiendas = new ArrayList<String>(){{add("Wal-Mart");
        add("https://www.walmart.com.ar/desodorante-antitraspirante-original-dove-85ml/p");}};
        final ArrayList<String> redes = new ArrayList<String>(){{add("FB");
            add("https://www.facebook.com/DoveMexico/");}};
        Producto nuevoProducto = new Producto(id, "Dove Desodorante", 74.6, "Dove",
                "https://cdns3-2.primor.eu/img/m/312.jpg",
                new ArrayList<String>(){{add("https://static.condisline.com/resize_395x416/images/catalog/large/930027.jpg");}},
                new ArrayList<CATEGORIAS>() {{add(CATEGORIAS.Cosmeticos);}},
                new ArrayList<ArrayList<String>>() {{add(tiendas);}},
                new ArrayList<ArrayList<String>>() {{add(redes);}}, "Desodorante en barra",
                0
        );
        ruta = database.getReference("Productos/" + id + "/");
        ruta.setValue(nuevoProducto);
        id = 2;
        nuevoProducto = new Producto(id, "Dove Desodorante", 74.6, "Dove",
                "https://cdns3-2.primor.eu/img/m/312.jpg",
                new ArrayList<String>(){{add("https://static.condisline.com/resize_395x416/images/catalog/large/930027.jpg");}},
                new ArrayList<CATEGORIAS>() {{add(CATEGORIAS.Cosmeticos);}},
                new ArrayList<ArrayList<String>>() {{add(tiendas);}},
                new ArrayList<ArrayList<String>>() {{add(redes);}}, "Desodorante en barra",
                0
        );
        ruta = database.getReference("Productos/" + id + "/");
        ruta.setValue(nuevoProducto);
    }
}
