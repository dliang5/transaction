import React from 'react';
import axios from 'axios';
class TransactionView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            transactions: null,
            isLoading: true
        };
    }

    componentDidMount = () => {
        axios.get('/transactions').then((response => {
            this.setState({
                transactions: response.data,
                isLoading: false
            });
            // console.log("hmm", this.state.transactions[0], this.state.transactions[0].userId);
        }))
    }

    render = () => {
        let row;
        if (!this.state.isLoading) {
            row = this.state.transactions.map((transaction, i) => {
                let newDate = new Date(transaction.transactionDate);
                let dateString = new Date(newDate.getTime() - (newDate.getTimezoneOffset() * 60000 ))
                                    .toISOString()
                                    .split("T")[0];
                console.log(dateString)
                return (
                    <tr key={i}>
                        <td>{transaction.userId}</td>
                        <td>{transaction.transactionId}</td>
                        <td>{transaction.transactionAmount}</td>
                        <td>{dateString}</td>
                        <td>{transaction.transactionRewards}</td>
                    </tr>
                );
            });
        }
        return (
            <React.Fragment>
                {this.state.isLoading ?
                    <div>LOADING...</div> :
                    <div>
                        <table>
                            <thead>
                                <tr>
                                    <th>USER</th>
                                    <th>TRANSACTION ID</th>
                                    <th>AMOUNTS</th>
                                    <th>DATE</th>
                                    <th>REWARD POINTS</th>
                                </tr>
                            </thead>
                            <tbody>
                                {row}
                            </tbody>
                        </table>
                    </div>
                }
            </React.Fragment>
        );
    }
}

export default TransactionView;