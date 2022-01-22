/// <reference path="../../../source/typescript/smart.elements.d.ts" />

import {CardView, DataAdapter} from "../../../source/typescript/smart.elements"


window.Smart('#cardView', class {
    get properties() {
        return <CardView>{
            dataSource: new window.Smart.DataAdapter(
                <DataAdapter>{
                    virtualDataSourceLength: 1000,
                    virtualDataSourceCache: true,
                    virtualDataSource: function (resultCallbackFunction: any, details: any) {
                        fetch('http://localhost:8080/vetan/screen/getReimburse',
                            { method: 'POST' })
                                return response.json();
                          
                    }
                     dataFields:
                            [
                            	'Expense: string',
                                'Invoice No: number',
                                'Amount: number',
                                'Claimed Amount: number',
                                'Entitled Amount: number',
                                'Vendor: string',
                                'price: number',
                                'Remarks: string'
                            ],
                }),
           columns: [
                    { label: 'Expense', dataField: 'expense', icon: 'expense' },
                    { label: 'Invoice No', dataField: 'inv_no', icon: 'inv_no' },
                    { label: 'Amount', dataField: 'inv_amt', icon: 'inv_amt'},
                    { label: 'Claimed Amount', dataField: 'claimed_amt', icon: 'claimed_amt' },
                    { label: 'Entitled Amount', dataField: 'ent_amt', icon: 'ent_amt' },
                    { label: 'Vendor', dataField: 'vendor', icon: 'vendor' },
                    { label: 'Remarks', dataField: 'remarks', icon: 'remarks'}
                   
                ],
            coverField: 'attachments',
            headerPosition: 'top',
            editable: true,
            titleField: 'firstName'
        };
    }
});/// <reference path="../../../source/typescript/smart.elements.d.ts" />

import {CardView, DataAdapter} from "../../../source/typescript/smart.elements"


window.Smart('#cardView', class {
    get properties() {
        return <CardView>{
            dataSource: new window.Smart.DataAdapter(
                <DataAdapter>{
                    virtualDataSourceLength: 1000,
                    virtualDataSourceCache: true,
                    virtualDataSource: function (resultCallbackFunction: any, details: any) {
                        fetch('http://localhost:8080/vetan/screen/getReimburse',
                            { method: 'POST' })
                                return response.json();
                          
                    }
                     dataFields:
                            [
                            	'Expense: string',
                                'Invoice No: number',
                                'Amount: number',
                                'Claimed Amount: number',
                                'Entitled Amount: number',
                                'Vendor: string',
                                'price: number',
                                'Remarks: string'
                            ],
                }),
           columns: [
                    { label: 'Expense', dataField: 'expense', icon: 'expense' },
                    { label: 'Invoice No', dataField: 'inv_no', icon: 'inv_no' },
                    { label: 'Amount', dataField: 'inv_amt', icon: 'inv_amt'},
                    { label: 'Claimed Amount', dataField: 'claimed_amt', icon: 'claimed_amt' },
                    { label: 'Entitled Amount', dataField: 'ent_amt', icon: 'ent_amt' },
                    { label: 'Vendor', dataField: 'vendor', icon: 'vendor' },
                    { label: 'Remarks', dataField: 'remarks', icon: 'remarks'}
                   
                ],
            coverField: 'attachments',
            headerPosition: 'top',
            editable: true,
            titleField: 'firstName'
        };
    }
});