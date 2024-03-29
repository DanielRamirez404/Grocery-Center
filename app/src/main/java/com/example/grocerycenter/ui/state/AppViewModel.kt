package com.example.grocerycenter.ui.state

import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.getListFromText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

  private val _uiState = MutableStateFlow(AppUiState())
  val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

  val compareList = mutableStateListOf(productList[0])
  val searchList = mutableStateListOf(productList[0])

  fun selectProduct(myProduct: Product) {
    _uiState.update { currentState ->
      currentState.copy(selectedProduct = myProduct)
    }
  }

  fun changeSearchText(text: String) {
    _uiState.update { currentState ->
      currentState.copy(searchText = text)
    }
  }

  fun searchProduct(text: String) {
    searchList.clear()
    searchList.addAll(getListFromText(text))
  }

  fun addProductToCompare(myProduct: Product) {
    compareList.add(myProduct)
    compareList.sortBy {
      if (it.hasOffer) it.discountedPrice else it.price
    }
  }

  fun removeProductToCompare(product: Product) {
    compareList.remove(product)
  }

  fun resetCompareList() {
    compareList.clear()
  }

  init {
    resetCompareList()
    searchList.clear()
  }

}