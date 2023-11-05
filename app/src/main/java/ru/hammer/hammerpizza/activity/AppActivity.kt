package ru.hammer.hammerpizza.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.hammer.hammerpizza.R
import ru.hammer.hammerpizza.viewmodel.PizzaViewModel


class AppActivity : AppCompatActivity(R.layout.app_activity) {
    private val viewModel: PizzaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadPizzas()
    }
}

