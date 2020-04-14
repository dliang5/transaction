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
                return (
                    <tr key={i}>
                        <td>{transaction.userId}</td>
                        <td>{transaction.transactionId}</td>
                        <td>{transaction.transactionAmount}</td>
                        <td>{transaction.transactionDate}</td>
                        <td>0</td>
                    </tr>
                );
            });
        }
        return (
            <React.Fragment>
                {this.state.isLoading ?
                    <div>LOADING...</div> :
                    <div>
                        <div>DONE LOADING...</div>
                        <table>
                            <tbody>
                                <th>USER</th>
                                <th>TRANSACTION ID</th>
                                <th>AMOUNTS</th>
                                <th>DATE</th>
                                <th>REWARD POINTS</th>

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