import React from 'react';
import axios from 'axios';

class TransactionSummary extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            transactions: null,
            isLoading: true
        };
    }

    componentDidMount = () => {
        axios.get('/summary').then((response => {
            this.setState({
                transactions: response.data,
                isLoading: false
            });
            console.log(this.state.transactions);
        }))
    }

    render = () => {
        let row;
        if (!this.state.isLoading) {
            row = this.state.transactions.map((transaction, i) => {
                return (
                    <tr key={i}>
                        <td>{transaction.userId}</td>
                        <td>{transaction.transactionMonth1}</td>
                        <td>{transaction.transactionMonth2}</td>
                        <td>{transaction.transactionMonth3}</td>
                        <td>{transaction.transactionTotal}</td>
                    </tr>
                );
            });
        }
        return (
            <React.Fragment>
                <div>
                    <div className="jumbotron">
                        <h1 className="display-4">3 Month Summary View</h1>
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
                            <thead>
                                <tr>
                                    <th>USER</th>
                                    <th>MONTH1</th>
                                    <th>MONTH2</th>
                                    <th>MONTH3</th>
                                    <th>TOTAL</th>
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

export default TransactionSummary;
