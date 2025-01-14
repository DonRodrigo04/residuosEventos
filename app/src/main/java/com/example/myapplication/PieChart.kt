package com.example.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawPieChart(
    values: List<Float>,
    colors: List<Color>
) {
    // Calcular el total de los valores
    val total = values.sum()
    // Ángulo inicial para el primer segmento del gráfico
    var startAngle = 0f

    // Crear un Canvas con un ancho completo y una altura de 300 dp
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        // Iterar sobre los valores y sus índices
        values.forEachIndexed { index, value ->
            // Calcular el ángulo de barrido para cada segmento
            val sweepAngle = (value / total) * 360f
            // Dibujar el arco para el segmento actual
            drawArc(
                color = colors[index], // Color del segmento
                startAngle = startAngle, // Ángulo inicial del segmento
                sweepAngle = sweepAngle, // Ángulo de barrido del segmento
                useCenter = true // Usar el centro del círculo
            )
            // Actualizar el ángulo inicial para el siguiente segmento
            startAngle += sweepAngle
        }
    }
}