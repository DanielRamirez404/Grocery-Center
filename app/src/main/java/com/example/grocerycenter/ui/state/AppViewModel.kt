package com.example.grocerycenter.ui.state

import androidx.compose.runtime.currentRecomposeScope
import androidx.lifecycle.ViewModel
import com.example.grocerycenter.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

  private val _uiState = MutableStateFlow(AppUiState())
  val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

  fun selectProduct(myProduct: Product) {
    _uiState.update { currentState ->
      currentState.copy(selectedProduct = myProduct)
    }
  }

  fun addProductToCompare(myProduct: Product) {
    _uiState.update { currentState ->
      currentState.apply { compareList.add(myProduct) }
    }
  }

  fun removeProductToCompare(index: Int) {
    _uiState.update { currentState ->
      currentState.apply { compareList.removeAt(index) }
    }
  }

  fun resetCompareList() {
    _uiState.update { currentState ->
      currentState.apply { compareList.clear() }
    }
  }

  init {
    resetCompareList()
  }

}