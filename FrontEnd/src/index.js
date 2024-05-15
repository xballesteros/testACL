// src/index.js
import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import store from './store';
import App from './App';
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080'; // Cambia la URL según tu configuración del backend

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById('root')
);
