import React, {useState} from 'react'
import TodoList from './TodoList';

const App = () => {
  const [task, setTask] = useState("")
  const [todos, setTodos] = useState([])
  const changeHandler = e =>{
    setTask(e.target.value)
  }
  const deleteHandler = (indexValue) => {
   const newTodos = todos.filter((todo,index) => index !== indexValue) 
   setTodos(newTodos)
  }
  const submitHandler = e => {
    e.preventDefault();
    const newTodos = [...todos,task]
    setTodos(newTodos)
    setTask("")
  }
  return (
    <div>
      <center>
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">To-Do Management Application</h5>
            <form onSubmit={submitHandler}>
              <input size="50" type="text" nmae="task" value={task} onChange={changeHandler}/> &nbsp;&nbsp;
              <input type="submit" value="Add" name="Add"/>
            </form>
            <TodoList todoslist={todos} deleteHandler={deleteHandler}/>
          </div>
        </div>
      </center>
    </div>
  );
}

export default App;