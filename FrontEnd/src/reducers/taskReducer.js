import { ADD_TASK, REMOVE_TASK, SET_TASKS } from '../actions/taskActions';

const initialState = {
    tasks: [],
};

const taskReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TASK:
            return {
                ...state,
                tasks: [...state.tasks, action.payload],
            };
        case REMOVE_TASK:
            return {
                ...state,
                tasks: state.tasks.filter(task => task.id !== action.payload),
            };
        case SET_TASKS:
            return {
                ...state,
                tasks: action.payload,
            };
        default:
            return state;
    }
};

export default taskReducer;
