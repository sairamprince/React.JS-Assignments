import React, { lazy, Suspense, useEffect, useState } from 'react';
import Card from './Card';
import CustomButton from './CustomButton';
import CircularProgress from '@mui/material/CircularProgress';


const LazyComponent = lazy(() => {
  return new Promise((reslove) => {
    setTimeout(()=> {
      reslove(import('./LazyComponent'));
    }, 5000);
  })
})

function App() {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    setTimeout(() => {
      setIsLoading(false);
    }, 5000);
  }, []);

  return (
    <div className="App">
      <center>
      <h1><i>Styling React Components</i></h1>
      <Card />
      
      &nbsp;
      <center>
        <h3>Component and integrate material UI</h3>
      <CustomButton/>
      <h4>-----------------------------------------------------------------------------------</h4>
      <h1>Lazy Loading</h1>
      </center>
      {isLoading ? (
          <CircularProgress />
        ) : (
      <Suspense fallback={<CircularProgress />}>
        <LazyComponent />
      </Suspense>
       )}
      </center>
    </div>
  );
}
export default App;
