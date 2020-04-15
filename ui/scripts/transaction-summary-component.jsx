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
        // if (!this.state.isLoading) {
        //     row = this.state.transactions.map((transaction, i) => {
        //         return (
        //             <tr key={i}>
        //                 <td>{transaction.userId}</td>
        //                 <td>{transaction.month1}</td>
        //                 <td>{transaction.month2}</td>
        //                 <td>{transaction.month2}</td>
        //                 <td>{transaction.total}</td>
        //             </tr>
        //         );
        //     });
        // }
        return (
            <React.Fragment>
                <div>
                    <div className="jumbotron">
                        <h1 className="display-4">Summary Transaction Views</h1>
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
                            <caption className="wording">3 Monthly Period Report</caption>  
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
                                <tr key={1}>
                                    <td>{this.state.transactions.userId}</td>
                                    <td>{this.state.transactions.transactionMonth1}</td>
                                    <td>{this.state.transactions.transactionMonth2}</td>
                                    <td>{this.state.transactions.transactionMonth3}</td>
                                    <td>{this.state.transactions.transactionTotal}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                }
            </React.Fragment>
        );
    }
}

export default TransactionSummary;
