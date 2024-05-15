import axios from 'axios';

export const ADD_TASK = 'ADD_TASK';
export const REMOVE_TASK = 'REMOVE_TASK';
export const SET_TASKS = 'SET_TASKS';

export const addTask = task => {
    return async dispatch => {
        try {
            const response = await axios.post('/testrest/insert?descripcion=' + task.descripcion);
            dispatch({ type: 'ADD_TASKS_SUCCESS', payload: "agregado" });
            window.location.reload();
        } catch (error) {
            console.error('Error fetching tasks:', error);
            dispatch({ type: 'ADD_TASKS_FAILURE', payload: error.message });
            alert("No se pudo agregar la tarea");
        }
    };
};

export const removeTask = id => {
    return async dispatch => {
        try {
            const response = await axios.post('/testrest/desactivar?id=' + id);
            dispatch({ type: 'DELETE_TASKS_SUCCESS', payload: "eliminado" });
            window.location.reload();
        } catch (error) {
            console.error('Error fetching tasks:', error);
            dispatch({ type: 'DELETE_TASKS_FAILURE', payload: error.message });
            alert("No se pudo eliminar la tarea");
        }
    };
};

export const editTasks = (edit, editId) => {
    return async dispatch => {
        try {
            const response = await axios.post('/testrest/editar?id=' + editId + '&descripcion=' + edit);
            dispatch({ type: 'EDIT_TASKS_SUCCESS', payload: "editado" });
            window.location.reload();
        } catch (error) {
            console.error('Error fetching tasks:', error);
            dispatch({ type: 'EDIT_TASKS_FAILURE', payload: error.message });
            alert("No se pudo editar la tarea");
        }
    };
}

export const fetchTasks = (setTasks) => {
    return async dispatch => {
        try {
            const response = await axios.get('/testrest/getTareas');
            dispatch({ type: 'FETCH_TASKS_SUCCESS', payload: setTasks(response.data) });
        } catch (error) {
            console.error('Error fetching tasks:', error);
            dispatch({ type: 'FETCH_TASKS_FAILURE', payload: error.message });
        }
    };
};
