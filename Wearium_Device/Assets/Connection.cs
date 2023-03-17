using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Threading;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System;

public class Connection : MonoBehaviour
{
    private Socket socket;
    private Socket receive;
    private IPEndPoint remoteEndPoint;

    private int messagesReceived = 0;
    private int trials = 18;
    private int balls = 0;

    private byte[] bufferBalls = new byte[4];

    private byte[] buffer;
    private bool ballsReceived = false;

    public GameObject ball;
    public GameObject spawn;


    private List<GameObject> ballsSpawned;
    public Connection()
    {
        this.ballsSpawned = new List<GameObject>();
    }
    // Start is called before the first frame update
    void Start()
    {
        this.startServer();
    }

    // Update is called once per frame
    void Update()
    {
        if(this.receive != null)
        {
            this.receive.BeginReceive(this.bufferBalls, 0, this.bufferBalls.Length, SocketFlags.None, new AsyncCallback(receiveBalls), this.receive);               
        }
    }
    
    private void startServer()
    {
        this.socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        this.remoteEndPoint = new IPEndPoint(IPAddress.Any, 6000);

        this.socket.Bind(this.remoteEndPoint);
        this.socket.Listen(1);
        this.socket.BeginAccept(new AsyncCallback(acceptClient), null);
       
    }

    private void acceptClient(IAsyncResult result)
    {
        this.receive = this.socket.EndAccept(result);
        byte[] data = new byte[100];
        data = Encoding.Default.GetBytes("Oculus Quest 2 Connected");
        this.receive.Send(data);
        
    }

    private void receiveBalls(IAsyncResult ar)
    {
        if(this.balls != 0)
        {
            this.destroyBalls();
        }

        if (BitConverter.IsLittleEndian)
        {
            Array.Reverse(this.bufferBalls);
        }
        this.balls = BitConverter.ToInt32(this.bufferBalls, 0);
        Debug.Log("Las bolas son: " + this.balls.ToString());
        this.buffer = Encoding.Default.GetBytes("Data Received correctly");
        this.receive.Send(this.buffer);
        this.spanwCircleOfBalls();
    }

    public void spanwCircleOfBalls()
    {
        float angle = 360 / this.balls;
        float angleCumu = 0;
        System.Random ran = new System.Random();
        double range = 1.5 - 0.5;
        double radius = Math.Round(ran.NextDouble() * range, 10);
        float center = 1.25f;
        
        for(int i = 0; i < this.balls; i++) 
        {
            if(angleCumu <= 90 && angleCumu >= 0)
            {
                double c1 = Math.Cos(angleCumu) * radius;
                double h = Math.Sin(angleCumu) * radius;
                Vector3 pos = new Vector3();
                pos.x = (float) c1 + center;
                pos.y = (float) h + center;
                pos.z = 1;
                this.placeBall(pos);
                angleCumu += angle;
                continue;
            }
            else if(angleCumu > 90 && angleCumu <= 180)
            {
                double auxAngle = 180 - angleCumu;
                double c1 = Math.Cos(auxAngle) * radius;
                double h = Math.Sin(auxAngle) * radius;
                Vector3 pos = new Vector3();
                pos.x = (float) (center - c1);
                pos.y = (float) (center + h);
                pos.z = 1;
                this.placeBall(pos);
                angleCumu += angle;
                continue;
            }
            else if(angleCumu > 180 && angleCumu <= 270)
            {
                double auxAngle = 270 - angleCumu;
                double c1 = Math.Cos(auxAngle) * radius;
                double h = Math.Sin(auxAngle) * radius;
                Vector3 pos = new Vector3();
                pos.x = (float)(center - c1);
                pos.y = (float)(center - h);
                pos.z = 1;
                this.placeBall(pos);
                angleCumu += angle;
                continue;
            }
            else if (angleCumu > 270 && angleCumu < 360) { }
            {
                double auxAngle = 360 - angleCumu;
                double c1 = Math.Cos(auxAngle) * radius;
                double h = Math.Sin(auxAngle) * radius;
                Vector3 pos = new Vector3();
                pos.x = (float)(center + c1);
                pos.y = (float)(center - h);
                pos.z = 1;
                this.placeBall(pos);
                angleCumu += angle;
                continue;
            }            
        }
    }

    private void placeBall(Vector3 pos)
    {
        var a = Instantiate(this.ball, pos, Quaternion.identity);
        this.ballsSpawned.Add(a);
    }

    private void destroyBalls()
    {
        foreach(var b in this.ballsSpawned)
        {
            Destroy(b);
        }
    }
}
