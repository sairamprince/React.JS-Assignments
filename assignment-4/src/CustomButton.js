import React from 'react';
import Button from '@mui/material/Button';

function CustomButton() {
  const buttonStyle = {
    backgroundColor: '#4caf50',
    color: 'white',
    '&:hover': {
      backgroundColor: '#388e3c',
    },
  };

  const handleClick = () => {
    alert('I have implement the material UI button in this component with inline styling');
  };

  return (
    <div>
      <Button variant="contained" style={buttonStyle} onClick={handleClick}>
        Click me
      </Button>
    </div>
  );
}

export default CustomButton;
