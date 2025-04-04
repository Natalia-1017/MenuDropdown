package com.example.menu

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Menu() {
    var expandedColor by remember { mutableStateOf(false) }
    var expandedFont by remember { mutableStateOf(false) }

    var selectedColorName by remember { mutableStateOf("Negro") }
    var selectedFontName by remember { mutableStateOf("Serif") }

    var appliedColor by remember { mutableStateOf(Color.Black) }
    var appliedFont by remember { mutableStateOf(FontFamily.Serif) }

    val colors = mapOf(
        "Rosado" to Color(0xFFFFC0CB),
        "Púrpura" to Color(0xFF800080),
        "Celeste" to Color(0xFF87CEEB),
        "Negro" to Color.Black,
        "Verde" to Color(0xFF008000),
        "Gris" to Color.Gray
    )

    val fonts = mapOf(
        "Serif" to FontFamily.Serif,
        "Cursive" to FontFamily.Cursive,
        "Sans Serif" to FontFamily.SansSerif,
        "Monospace" to FontFamily.Monospace,
        "Condensed" to FontFamily.SansSerif
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Opciones",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de Color
            Text(
                text = "Color:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Box {
                Button(
                    onClick = { expandedColor = true },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366)), // Azul oscuro
                    modifier = Modifier.border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                ) {
                    Text(selectedColorName, fontSize = 16.sp, color = Color.White) // Texto en blanco
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "Desplegable", tint = Color.White) // Triángulo en blanco
                }
                DropdownMenu(expanded = expandedColor, onDismissRequest = { expandedColor = false }) {
                    colors.keys.forEach { colorName ->
                        DropdownMenuItem(text = { Text(colorName) }, onClick = {
                            selectedColorName = colorName
                            expandedColor = false
                        })
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botón de Tipografía
            Text(
                text = "Tipografía:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Box {
                Button(
                    onClick = { expandedFont = true },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366)), // Azul oscuro
                    modifier = Modifier.border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                ) {
                    Text(selectedFontName, fontSize = 16.sp, color = Color.White) // Texto en blanco
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "Desplegable", tint = Color.White) // Triángulo en blanco
                }
                DropdownMenu(expanded = expandedFont, onDismissRequest = { expandedFont = false }) {
                    fonts.keys.forEach { fontName ->
                        DropdownMenuItem(text = { Text(fontName) }, onClick = {
                            selectedFontName = fontName
                            expandedFont = false
                        })
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Cuadro de Texto con los cambios aplicados
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hola",
                    fontSize = 28.sp,
                    color = appliedColor,
                    fontFamily = appliedFont
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Botón Aplicar
            Button(
                onClick = {
                    appliedColor = colors[selectedColorName] ?: Color.Black
                    appliedFont = fonts[selectedFontName] ?: FontFamily.SansSerif
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = Modifier.border(2.dp, Color.Black, RoundedCornerShape(10.dp))
            ) {
                Text("Aplicar", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}
