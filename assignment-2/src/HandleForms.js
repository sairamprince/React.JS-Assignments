import React, { useState } from 'react';

const HandleForms = () => {
  const [name, setName] = useState('');
  const [number, setNumber] = useState('');
  const [userData, setUserData] = useState([]);

  const handleSubmit = (event) => {
    event.preventDefault();

    if (name && number) {
      const newUser = { name, number };
      setUserData([...userData, newUser]);
      setName('');
      setNumber('');
    }
  };

  return (
    <div>
      <h2>User Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        </div>
        <div>
          <label>Number:</label>
          <input type="text" value={number} onChange={(e) => setNumber(e.target.value)} />
        </div>
        <button type="submit">Save/Register</button>
      </form>
      <h2>Registered Users</h2>
      <ul>
        {userData.map((user, index) => (
          <li key={index}>
            Name: {user.name}, Number: {user.number}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default HandleForms;
