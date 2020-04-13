import React from 'react';
import axios from 'axios';
class TransactionView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            transactions: []
        };
    }

    componentDidMount = () => {
        axios.get('/transactions').then((response => {
            this.setState({
                transactions: response.data
            });
        }))
    }

    // todo: refactor to use Transaction component after getting this to work
    render = () => {
        <table>
            <tbody>
                this.state.transactions.map((transaction) => {
                    <tr>
                        <td>{transaction.userId}</td>
                    </tr>
                    <tr>
                        <td>{transaction.transactionId}</td>
                    </tr>
                    <tr>
                        <td>{transaction.transactionAmount}</td>
                    </tr>
                    <tr>
                        <td>{transaction.transactionDate}</td>
                    </tr>
                })
            </tbody>
        </table>
    }
}

export default TransactionView;