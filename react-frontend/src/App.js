import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

function App() {
  const [todos, setTodos] = useState([]);
  const [task, setTask] = useState({ "name": "", "description": "", "deadline": new Date(), "category": { "name": null } });
  const [editIndex, setEditIndex] = useState(null);
  useEffect(() => {
    fetchTodos();

  }, []);

  // get all
  const fetchTodos = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/todos');
      setTodos(response.data);
    } catch (error) {
      console.error('Error fetching todos:', error);
    }
  };

  const addTodo = async () => {
    try {

      if (editIndex !== null) {
        // Edit existing todo
        await axios.put(`http://localhost:8080/api/todos/${todos[editIndex].id}`, task);
        const updatedTodos = [...todos];
        updatedTodos[editIndex] = task;
        setTodos(updatedTodos);
        setEditIndex(null);
      }
      else {
        // Add new todo
        const response = await axios.post('http://localhost:8080/api/todos', task);
        setTodos([...todos, response.data]);
      }

    } catch (error) {
      console.error('Error adding todo:', error);
    }
  };

  const removeTodo = async (index) => {
    try {
      const todoId = todos[index].id;

      await axios.delete(`http://localhost:8080/api/todos/${todoId}`);
      const newTodos = [...todos];
      newTodos.splice(index, 1);
      setTodos(newTodos);
      setEditIndex(null);
    } catch (error) {
      console.error('Error removing todo:', error);
    }
  };

  const editTodo = (index) => {
    console.log(todos[index]);

    // replace back string for Date
    let task = todos[index];
    task.deadline = new Date(task.deadline);

    setTask(todos[index]);
    setEditIndex(index);
  };

  const cancelEdit = () => {
    setTask({
      name: '',
      description: '',
      deadline: new Date(),
      category: {
        name: '',
      },
    });
    setEditIndex(null);
  };

  return (
    <div className="App">
      <h1>Todo List</h1>
      <div>
        <label>Name:</label>
        <input
          type="text"
          value={task.name}
          onChange={(e) => setTask({ ...task, name: e.target.value })}
          placeholder="Enter a name"
        />
        <label>Description:</label>
        <input
          type="text"
          value={task.description}
          onChange={(e) => setTask({ ...task, description: e.target.value })}
          placeholder="Enter a description"
        />
        <label>Deadline:</label>
        <DatePicker
          selected={task.deadline}
          onChange={(date) => setTask({ ...task, deadline: date })}
          showTimeSelect
          timeFormat="HH:mm"
          timeIntervals={15}
          timeCaption="Time"
          dateFormat="MMMM d, yyyy h:mm aa"
        />
        <label>Category:</label>
        <input
          type="text"
          value={task.category.name}
          onChange={(e) => setTask({ ...task, category: { ...task.category, name: e.target.value } })}
          placeholder="category"
        />
        <button onClick={addTodo}>{editIndex !== null ? 'Update' : 'Add'}</button>
        {editIndex !== null && <button onClick={cancelEdit}>Cancel</button>}

      </div>
      <ul>
        {todos.map((todo, index) => (
          <li key={index}>
            <b>{todo.name}</b>:{todo.description == '' ? <i>no description</i> : todo.description} {todo.category == undefined ? '' : '(' + todo.category.name + ')'} {todo.deadline == undefined ? '' : '- ' + todo.deadline.toString().split('T')[0]}
            <button onClick={() => editTodo(index)}>Edit</button>
            <button onClick={() => removeTodo(index)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;