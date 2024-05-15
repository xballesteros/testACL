// reducers/index.js
import { combineReducers } from 'redux';
import taskReducer from './taskReducer'; // Asegúrate de que el nombre del archivo y la ruta sean correctos

const rootReducer = combineReducers({
    tasks: taskReducer,
    // Otros reductores si los tienes
});

export default rootReducer;
