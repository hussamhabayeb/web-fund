# from flask import Flask, render_template  # added render_template!
# app = Flask(__name__)                     
    
# @app.route('/')                           
# def hello_world():
#    print('hussam')
#    return render_template('playg.html')  
    
# if __name__=="__main__":
#     app.run(debug=True)   
from flask import Flask, render_template

app = Flask(__name__)


# @app.route('/')
# def hello():
    
    
#     return "hussam"


@app.route("/<name>/<times>/<color>")
def index(name,times,color):
    return render_template ("playgroundht.html",
                            some_name=name, 
                            num=int(times)
                            ,same_color=color)	
if __name__ == '__main__':
    app.run(debug=True)
