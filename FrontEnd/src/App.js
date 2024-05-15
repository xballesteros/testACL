// App.js
import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { fetchTasks, addTask, removeTask, editTasks } from './actions/taskActions';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';
import Modal from 'react-modal';

const App = () => {
  const dispatch = useDispatch();
  const [tasks, setTasks] = useState([]);
  const [edit, setEdit] = useState('');
  const [editId, setEditId] = useState('');
  const [modalIsOpen, setModalIsOpen] = useState(false);

  useEffect(() => {
    dispatch(fetchTasks(setTasks));
  }, [dispatch]);

  const handleSubmit = descripcion => {
    if (descripcion.descripcion !== null || descripcion.descripcion !== '') {
      dispatch(addTask({ descripcion }));
    } else {
      alert("Debe ingresar una descripción");
    }
  };

  const handleDelete = id => {
    dispatch(removeTask(id));
  };

  const handleEdit = (edit,editId) => {
    dispatch(editTasks(edit,editId));
  };

  return (
    <div>
      <TaskForm onSubmit={handleSubmit} />
      <>
        {tasks.length > 0 ? (
          <TaskList tasks={tasks} onDelete={handleDelete} setModalIsOpen={setModalIsOpen} setEditId={setEditId} />
        ) : (
          <p>Sin Tareas</p>
        )}
        <Modal
          isOpen={modalIsOpen}
          onRequestClose={() => setModalIsOpen(false)}
          contentLabel="Example Modal"
        >
          <h2>Editar Tarea</h2>
          <input
            type="text"
            placeholder="Descripción"
            value={edit}
            onChange={e => setEdit(e.target.value)}
          />
          <button onClick={() => handleEdit(edit,editId)}>Guardar</button>
          <br/>
          <br/>
          <button onClick={() => setModalIsOpen(false)}>Cancelar</button>
        </Modal>
      </>
    </div>
  );
};

export default App;
