import React, { useState } from 'react';
import './Card.css';

const Card = () => {
  const [isHovered, setIsHovered] = useState(false);

  const cardStyles = {
    backgroundColor: isHovered ? '#2980b9' : '#3498db',
    padding: '20px',
    border: 'none',
    borderRadius: '10px',
    boxShadow: isHovered ? '0 8px 16px rgba(0, 0, 0, 0.3)' : '0 4px 8px rgba(0, 0, 0, 0.2)',
    textAlign: 'center',
    width: '300px',
    color: 'white',
    fontFamily: 'Arial, sans-serif',
    transition: 'background-color 0.3s, box-shadow 0.3s',
  };

  const titleStyles = {
    fontSize: '24px',
    fontStyle: 'italic',
    marginBottom: '10px',
  };

  const contentStyles = {
    fontSize: '18px',
    lineHeight: '1.5',
  };

  return (
    <div>
      <div
      style={cardStyles}
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
    >
      <h2 style={titleStyles}>Inline CSS Example</h2>
      <p style={contentStyles}>This content is styled using inline CSS.</p>
    </div>
    <h3>--------------------------------------------------------------------------</h3>

      {/* Use external stylesheet with className */}
      <div className="card">
        <h2 className="card-title"><i>ClassName CSS Example</i></h2>
        <p className="card-content">This content is styled using className from an external CSS file.</p>
      </div>
    </div>
  );
};

export default Card;
