ReactDOM.render(
    <h1>Hello, world!</h1>,
    document.getElementById( 'example' )
);

class Toggle extends React.Component {
    constructor( props ) {
        super( props );
        this.state = { isToggleOn: true };

        // 这个绑定是必要的，使`this`在回调中起作用
        this.handleClick = this.handleClick.bind( this );
    }

    handleClick() {
        this.setState( prevState => ( {
            isToggleOn: !prevState.isToggleOn
        } ) );
    }

    render() {
        return (
            <button onClick={this.handleClick}>
                {this.state.isToggleOn ? 'ON' : 'OFF'}
            </button>
        );
    }
}

ReactDOM.render(
    <Toggle />,
    document.getElementById( 'root' )
);



class MyComponent extends React.Component {
    constructor( props ) {
        super( props );
        this.state = {
            error: null,
            isLoaded: false,
            items: []
        };
    }

    componentDidMount() {
        fetch( "http://localhost:8083/test/ajax", {
            method: 'GET',
            mode: 'cors', // 避免cors攻击
            credentials: 'include'
        } ).then( res => res.json() )
            .then(
            ( result ) => {
                this.setState( {
                    isLoaded: true,
                    items: result
                } );
            },
            // Note: it's important to handle errors here
            // instead of a catch() block so that we don't swallow
            // exceptions from actual bugs in components.
            ( error ) => {
                this.setState( {
                    isLoaded: true,
                    error: error
                } );
            }
            )
    }

    render() {
        const { error, isLoaded, items } = this.state;
        if ( error ) {
            return <div>Error: {error.message}</div>;
        } else if ( !isLoaded ) {
            return <div>Loading...</div>;
        } else {
            return (
                <ul>
                    {items.map( item => (
                        <li key={item.username}>
                            {item.username} {item.role}
                        </li>
                    ) )}
                </ul>
            );
        }
    }
}

ReactDOM.render(
    <MyComponent />,
    document.getElementById( 'ajax' )
);
