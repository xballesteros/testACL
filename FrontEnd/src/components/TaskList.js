import React from 'react';

const formatDate = (dateString) => {
    const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    const parts = dateString.split(" ");

    const monthIndex = months.findIndex(month => month === parts[1]);
    const day = parseInt(parts[2]);
    const year = parseInt(parts[5]);

    // Ajuste para convertir el día a dos dígitos
    const formattedDay = day < 10 ? `0${day}` : day;

    // Ajuste para agregar 1 al mes, ya que los meses en JavaScript comienzan desde 0
    const formattedMonth = monthIndex < 9 ? `0${monthIndex + 1}` : monthIndex + 1;

    return `${formattedDay}/${formattedMonth}/${year}`;
};


const TaskList = ({ tasks, onDelete, setModalIsOpen, setEditId }) => {
    return (
        <div>
            <h2>Lista de Tareas</h2>
            <ul>
                {tasks.map(task => (
                    <li key={task.id}>
                        {task.descripcion} - {formatDate(task.fechaCreacion)} - 
                        <button onClick={() => { setModalIsOpen(true); setEditId(task.id); }}>Editar</button>
                        <button onClick={() => onDelete(task.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TaskList;
