package br.com.brq.listdelivery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.brq.listdelivery.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class PrincipalActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab : FloatingActionButton = findViewById(R.id.fab_adicionar_item)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Adicionar evento de criar tarefas", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val menu_layout : DrawerLayout = findViewById(R.id.menu_layout)
        val nav_view : NavigationView = findViewById(R.id.nav_view)
        val nav_host : NavController = findNavController(R.id.nav_principal_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_pedidos, R.id.nav_entregues, R.id.nav_atrasados, R.id.nav_cancelados), menu_layout)
        setupActionBarWithNavController(nav_host, appBarConfiguration)
        nav_view.setupWithNavController(nav_host)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}