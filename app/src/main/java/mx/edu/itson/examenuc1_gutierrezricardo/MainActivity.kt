package mx.edu.itson.examenuc1_gutierrezricardo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etCantidad:EditText = findViewById(R.id.etCantidad)
        val etProducto:EditText = findViewById(R.id.etProducto)
        val etPrecio:EditText = findViewById(R.id.etPrecio)

        val tvCantidad1:TextView = findViewById(R.id.tvCantidad1)
        val tvCantidad2:TextView = findViewById(R.id.tvCantidad2)
        val tvCantidad3:TextView = findViewById(R.id.tvCantidad3)

        val tvProducto1:TextView = findViewById(R.id.tvProducto1)
        val tvProducto2:TextView = findViewById(R.id.tvProducto2)
        val tvProducto3:TextView = findViewById(R.id.tvProducto3)

        val tvPrecio1:TextView = findViewById(R.id.tvPrecio1)
        val tvPrecio2:TextView = findViewById(R.id.tvPrecio2)
        val tvPrecio3:TextView = findViewById(R.id.tvPrecio3)

        val tvSubtotal:TextView = findViewById(R.id.tvSubtotal)
        val tvIVA:TextView = findViewById(R.id.tvIVA)
        val tvTotal:TextView = findViewById(R.id.tvTotal)

        val btnAgregar:Button = findViewById(R.id.btnAgregar)

        var productosAgregados:Int = 0

        btnAgregar.setOnClickListener {
            if (productosAgregados == 0) {
                tvCantidad1.setText("1")
                tvProducto1.setText(etProducto.text.toString())
                tvPrecio1.setText((etPrecio.text.toString().toDouble() * etCantidad.text.toString().toInt()).toString())
                productosAgregados++
            } else if (productosAgregados == 1) {
                tvCantidad2.setText("2")
                tvProducto2.setText(etProducto.text.toString())
                tvPrecio2.setText((etPrecio.text.toString().toDouble() * etCantidad.text.toString().toInt()).toString())
                productosAgregados++
            } else if (productosAgregados == 2) {
                tvCantidad3.setText("3")
                tvProducto3.setText(etProducto.text.toString())
                tvPrecio3.setText((etPrecio.text.toString().toDouble() * etCantidad.text.toString().toInt()).toString())
                productosAgregados++
            }

            if (productosAgregados == 3) {
                tvSubtotal.setText((tvPrecio1.text.toString().toDouble() + tvPrecio2.text.toString().toDouble() + tvPrecio3.text.toString().toDouble()).toString())
                tvIVA.setText((tvSubtotal.text.toString().toDouble() * 0.16).toString())
                tvTotal.setText((tvSubtotal.text.toString().toDouble() + tvIVA.text.toString().toDouble()).toString())
            }

            etCantidad.setText("")
            etProducto.setText("")
            etPrecio.setText("")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}