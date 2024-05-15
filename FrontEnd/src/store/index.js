// src/store/index.js
import { createStore, applyMiddleware } from 'redux';
import {thunk} from 'redux-thunk';

import rootReducer from '../reducers'; // Asegúrate de que la ruta sea correcta y el archivo exista

const store = createStore(rootReducer, applyMiddleware(thunk));

export default store;
