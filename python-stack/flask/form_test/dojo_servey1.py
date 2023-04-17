from flask import Flask, render_template ,request
app = Flask(__name__)



@app.route('/')
def index_show():
    return render_template("form_test.html")

@app.route('/process', methods=["POST"])
def index_form():
    
    return render_template ("info.html",
                           name= request.form['username'] 
                           ,em=request.form ['email']
                           ,locate=request.form['location'],
                           fav=request.form ['languege'],
                           text=request.form ['message'])             
    


if __name__ == "__main__":
    app.run(debug=True)

