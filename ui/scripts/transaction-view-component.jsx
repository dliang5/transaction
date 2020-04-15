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
                // console.log(dateString)
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
                <div>
                    <div className="jumbotron">
                        <h1 className="display-4">Transaction View</h1>
                        <hr className="my-4"/>
                        <p className="lead">
                            <a className="btn btn-primary btn-lg" href="#" role="button">
                                Learn More
                            </a>
                        </p>
                    </div>
                </div>

                {this.state.isLoading ?
                    <div>LOADING...</div> :
                    <div>
                        <table className="table">
                            <caption>RAW DATA</caption>
                            <thead>
                                <tr>
                                    <th>USER</th>
                                    <th>ID</th>
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