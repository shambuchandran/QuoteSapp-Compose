package com.example.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.models.QuoteData
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {
    var data= emptyArray<QuoteData>()
    var currentQuote:QuoteData?=null
    var currentPage= mutableStateOf(Pages.LISTINGPAGE)
    var isDataLoaded= mutableStateOf(false)
    fun loadAssetsFromFile(context: Context){
        val inputStream=context.assets.open("quote.json")
        val size=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer, Charsets.UTF_8)
        val gson=Gson()
        data=gson.fromJson(json,Array<QuoteData>::class.java)
        isDataLoaded.value=true
    }
    fun switchPage(quoteData:QuoteData?){
        if (currentPage.value == Pages.LISTINGPAGE){
            currentQuote=quoteData
            currentPage.value=Pages.DETAILPAGE
        }else{
            currentPage.value=Pages.LISTINGPAGE
        }
    }
}