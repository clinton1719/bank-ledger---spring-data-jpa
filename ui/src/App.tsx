import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { AccountComponent } from './components/AccountComponent';
import type { Account } from './types/Account';
import { Box } from '@mui/material';

const App = () => {
  const [accounts, setAccounts] = useState<Account[]>([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    fetch('/api/account/accounts')
      .then(response => response.text())
      .then(data => {
        setAccounts(JSON.parse(data));
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
    <Box sx={{
      py: 8,
      px: 3,
      mx: 'auto',
      textAlign: 'center'
    }}>
      <Typography
        variant="h3"
        sx={{
          mb: 4,
          fontWeight: 700,
          color: 'primary.main',
          lineHeight: 1.2
        }}
      >
        Learning by breaking series
      </Typography>

      <Typography
        variant="h4"
        sx={{
          mb: 8,
          fontWeight: 600,
          color: 'primary.secondary',
          letterSpacing: '-0.02em'
        }}
      >
        Spring Data JPA • Bank Ledger
      </Typography>

      <Box sx={{
        display: 'grid',
        gridTemplateColumns: { xs: '1fr', md: 'repeat(2, 1fr)', lg: 'repeat(5, 1fr)' },
        gap: 3,
        mx: 'auto'
      }}>
        {accounts.map((account: Account) => (
          <AccountComponent
            key={account.id}
            accountName={account.accountName}
            accountBalance={account.accountBalance}
          />
        ))}
      </Box>
    </Box>
  );

}

export default App
