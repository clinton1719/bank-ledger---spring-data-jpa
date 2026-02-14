import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';

const App = () => {
  const [accounts, setAccounts] = useState('');
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    fetch('/api/account/accounts')
      .then(response => response.text())
      .then(data => {
        setAccounts(data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <Typography variant="h1" className='text-center pt-5'>
        Learning by breaking series - Spring Data JPA
      </Typography>
      <Typography variant="h2" className='text-center p-5'>
        Bank Ledger
      </Typography>
      <Typography variant="body1" className='text-center p-5'>
        {accounts}
      </Typography>
    </>
  )
}

export default App
