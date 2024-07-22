package com.example.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotesapp.models.QuoteData

@Composable
fun QuoteList(data: Array<QuoteData>,onClick:(quoteData:QuoteData)-> Unit) {
 LazyColumn(content = {
     items(data){
         QuoteListItem(quoteData = it,onClick)
     }
 }) 
    
}