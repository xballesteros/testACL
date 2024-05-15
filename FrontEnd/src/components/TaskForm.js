import React, { useState } from 'react';

const TaskForm = ({ onSubmit }) => {
    const [descripcion, setDescripcion] = useState('');

    const handleSubmit = e => {
        e.preventDefault();
        if (!descripcion.trim()) return alert("Debe ingresar una descripción");
        onSubmit(descripcion);
        setDescripcion('');
    };

    return (
        <div>
            <h2>Agregar Tarea</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Descripción"
                    value={descripcion}
                    onChange={e => setDescripcion(e.target.value)}
                />
                <button type="submit">Agregar</button>
            </form>
        </div>
    );
};

export default TaskForm;
