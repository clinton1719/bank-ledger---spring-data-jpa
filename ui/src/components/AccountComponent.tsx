import { Card, CardContent, Typography } from "@mui/material";
import { styled } from "@mui/material/styles";

interface AccountProps {
    accountName: string;
    accountBalance: number;
}

const StyledCard = styled(Card)(() => ({
    minWidth: 280,
    height: 120,
    transition: "all 0.2s ease-in-out",
    "&:hover": {
        transform: "translateY(-4px)",
        boxShadow: "0 12px 32px rgba(0,0,0,0.15)",
    },
}));

export function AccountComponent({ accountName, accountBalance }: AccountProps) {
    return (
        <StyledCard elevation={2}>
            <CardContent sx={{ p: 2.5, height: "100%", display: "flex", flexDirection: "column" }}>
                <Typography variant="subtitle2" color="text.secondary" sx={{ mb: 1 }}>
                    {accountName}
                </Typography>

                <Typography
                    variant="h4"
                    sx={{
                        fontWeight: 700,
                        color: accountBalance >= 0 ? "success.main" : "error.main",
                        lineHeight: 1.1
                    }}
                >
                    {accountBalance.toLocaleString("en-IN", {
                        style: "currency",
                        currency: "INR",
                    })}
                </Typography>
            </CardContent>
        </StyledCard>
    );
}
